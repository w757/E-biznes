
FROM golang:1.18-alpine AS builder

RUN apk add --no-cache build-base

ENV APP_DIR=/go/src/app
WORKDIR $APP_DIR

COPY . .

RUN go build -o main .

FROM alpine:latest

RUN apk --no-cache add libc6-compat

COPY --from=builder /go/src/app/main /usr/local/bin/app

ENV PORT=8080

EXPOSE $PORT

CMD ["app"]
