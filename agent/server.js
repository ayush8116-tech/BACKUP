const { Server } = require("engine.io");
const express = require("express");
const http = require("http");
const { Socket } = require("socket.io");
const app = express();
const server = http.createServer(app);

const io = new Server(server, {
  cors: {
    origin: "*",
  },
});

const { Board, Led } = require("johnny-five");
const board = new Board();

board.on("ready", () => {
  const white = new Led(8);
  const red = new Led(2);

  app.use(express.json());

  app.post("/led/on", (req, res) => {
    console.log("request came...");
    const { color } = req.body;

    if(color === "white") {
      white.on();
    }
    
    if(color === "red") {
      red.on();
    }

    res.send("light turned on");
  });

  app.post("/led/off", (req, res) => {
    console.log("request came...");
    const { color } = req.body;
    
    if(color === "white") {
      white.stop().off();
    } 

    if(color === "red") {
      red.stop().off();
    }

    res.send("light turned off");
  });

  app.post("/led/blink-on", (req, res) => {
    console.log("request came...");
    const { timePeriod } = req.body;

    white.blink(+timePeriod);
    res.send("light is blinking");
  });

  app.get("/led/blink-off", (req, res) => {
    console.log("request came...");
    white.stop();
    res.send("light is not blinking");
  });
});

server.listen(3000, () => {
  console.log("server is listening on port 3000");
});
