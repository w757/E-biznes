
FROM node:14-alpine AS builder


RUN apk add --no-cache npm
RUN apk add --update nodejs npm

WORKDIR /app

COPY package.json ./

COPY . .

RUN npm install
RUN npm run build

FROM nginx:alpine

COPY --from=builder /app/build /usr/share/nginx/html


EXPOSE 3000

CMD ["nginx", "-g", "daemon off;"]
