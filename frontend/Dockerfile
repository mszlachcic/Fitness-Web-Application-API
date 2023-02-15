FROM node:latest as node
WORKDIR /frontend
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=node /frontend/dist/frontend /usr/share/nginx/html
