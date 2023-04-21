FROM node:18-alpine3.15 as build
WORKDIR /app
# Copy all files from current directory to working dir in image
COPY . .
# install node modules and build assets
RUN npm i && npm run build

FROM nginx as runtime
COPY --from=build /app/dist/ui /usr/share/nginx/html
