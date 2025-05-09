# Step 1: Build the app
FROM node:alpine as build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install

COPY . .
RUN npm run build

# Step 2: Serve the built app using `serve`
FROM node:alpine as production

WORKDIR /app

# Install a lightweight HTTP server
RUN npm install -g serve

# Copy built files from previous stage
COPY --from=build /app/dist ./dist

EXPOSE 3000

# Serve the dist folder
CMD ["serve", "-s", "dist", "-l", "3000"]
