# Step 1: Build the React app
FROM node:18 AS build

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json (or yarn.lock) and install dependencies
COPY package*.json ./
RUN npm install

# Copy all source files into the container
COPY . .

# Build the app for production
RUN npm run build

# Step 2: Serve the built app using a static server
FROM nginx:alpine