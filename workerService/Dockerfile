FROM denoland/deno:2.3.7 AS builder

WORKDIR /app

COPY deno.json deno.lock ./

RUN deno cache deno.json

COPY . .

RUN deno cache ./main.ts

FROM denoland/deno:distroless-2.3.7

WORKDIR /app

COPY --from=builder /app /app

CMD ["run", "--allow-net", "--allow-env", "./main.ts"]