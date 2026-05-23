import { Redis } from "@db/redis";

const sleep = (ms: number): Promise<void> => {
  return new Promise((resolve) => setTimeout(resolve, ms));
};

export const worker = async (client: Redis, queue: string) => {
  while (true) {
    console.log("asking work");
    const res = await client.brpop(5, queue);
    if (res) {
      await sleep(5000);
      console.log(res?.[1]);
      const task = await JSON.parse(res?.[1]);
      console.log("got work ",task.bookingId);
    

      const result = await fetch(`http://localhost:8080/api/update-bookings/${task.bookingId}`, {
        method: "PUT"
      })
      console.log("task completed and updated");

      console.log(await result.json());
    }
  }
};
