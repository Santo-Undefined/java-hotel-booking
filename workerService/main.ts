import { connect } from "@db/redis";
import { worker } from "./src/worker.ts";

const main = async () => {
  try {
    const client = await connect({ hostname: "127.0.0.1", port: 6379 });
    await client.connect();

    worker(client, "task-queue");

  } catch (error) {
    console.log(error);
  }
};

main();
