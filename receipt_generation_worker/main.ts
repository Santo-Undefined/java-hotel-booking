import { connect } from "@db/redis";
import { worker } from "./src/worker.ts";

const main = async () => {
  try {
    const redisUrl = Deno.env.get("REDIS_HOST") || "redis://redis";
    console.log("redis url ==>", redisUrl);
    const client = await connect({ hostname: "redis", port: 6379 });
    await client.connect();

    worker(client, "task-queue");
  } catch (error) {
    console.log(error);
  }
};

main();
