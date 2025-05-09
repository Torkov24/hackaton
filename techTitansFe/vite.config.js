import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
    plugins: [react()],
    server: {
        host: '0.0.0.0',
        port: 3000,
    },
    base: './',
    build: {
        rollupOptions: {
            output: {
                format: 'iife', // Use IIFE instead of ESM
                // Ensure all assets use relative paths
                assetFileNames: 'assets/[name].[ext]',
                chunkFileNames: 'assets/[name].[hash].js',
                entryFileNames: 'assets/[name].[hash].js',
                manualChunks: undefined
            }
        },
        // Generate assets with proper paths
        assetsInlineLimit: 0,
        cssCodeSplit: false,
        outDir: 'dist',
        emptyOutDir: true
    }
})
