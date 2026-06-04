const OLLAMA_HOST = process.env.OLLAMA_HOST || 'http://localhost:11434';
const MODEL = 'functiongemma';

type State = "on" | "off"
type Color = "white" | "red"

async function toggleLed(state : string, color : string) {
  await fetch(`http://localhost:3000/led/${state}`, {
    method : "POST",
         headers: {
    "Content-Type": "application/json"
  },
    body : JSON.stringify({
      color
    })
  });
}

async function blinkLight(timePeriod : string) {
  await fetch(`http://localhost:3000/led/blink-on`, {
    method : "POST",
     headers: {
    "Content-Type": "application/json"
  },
    body : JSON.stringify({
      timePeriod : +timePeriod
    })
  });
}

const tools = [
  {
    type: 'function',
    function: {
      name: 'toggle-led',
      description: 'turn on or turn off the light',
      parameters: {
        type: 'object',
        properties: {
          "state" : {type : "string", description : "state of the light (on / off)"},
          "color" : {type : "string", description : "color of the light (red / white)"},
        },
        required: ['state', 'color'],
      },
    },
  },
  {
    type: 'function',
    function: {
      name: 'blink-led',
      description: 'blink the led with time delay in milliseconds(period)',
      parameters: {
        type: 'object',
        properties: {
          "timePeriod" : {type : "string", description : "delay in milliseconds(timePeriod should convert to milliseconds if any other unit found) between the light on and off"},
        },
        required : ['timePeriod'],
      },
    },
  }
];

const callTool = async(tool : string, args : Record<string, string>) => {
 const fn: Record<string, () => Promise<void>> = {
  "toggle-led": () => toggleLed(args.state, args.color),
  "blink-led": () => blinkLight(args.timePeriod),
};

await fn[tool]();
};

interface Message {
  role: string;
  content: string | void;
  tool_calls?: { function: { name: string; arguments: Record<string, string> } }[];
}

interface ChatResponse {
  message: Message;
}

async function chat(messages: Message[]): Promise<ChatResponse> {
  const response = await fetch(`${OLLAMA_HOST}/api/chat`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ model: MODEL, messages, tools, stream: false }),
  });

  if (!response.ok) {
    throw new Error(`HTTP error: ${response.status} ${await response.text()}`);
  }

  return response.json();
}

async function main() {
  while(true) {
    const messages: Message[] = [];
    const message  = prompt(">>> ");
    if(message === "/bye") return;

    messages.push({role:'user',content:message!});
    
    const response = await chat(messages);
    
    if (response.message.tool_calls?.length) {
      const tool = response.message.tool_calls[0];
      // console.log(`Calling: ${tool.function.name}(${JSON.stringify(tool.function.arguments)})\n`);
      
      const args = tool.function.arguments;

      const result = await callTool(tool.function.name, args);
      // console.log('Function Result:', result);
      
      messages.push(response.message);
      messages.push({ role: 'tool', content: result });
      
      const final = await chat(messages);
      console.log('Response:', final.message.content);
    } else {
      console.log('Response     :', response.message.content);
    }
  }
}

main().catch(console.error);
