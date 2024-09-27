// webpack.config.js (For compiling TypeScript and React):

const path = require('path');

module.exports = {
    entry: './src/renderer/index.tsx',
    target: 'electron-renderer',  // Ensure compatibility with Electron
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.ts', '.tsx', '.js', '.jsx'], // Extensions for resolution
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/, // For TypeScript/TSX files
                use: 'ts-loader', // Use ts-loader to compile TypeScript
                exclude: /node_modules/,
            },
            {
                test: /\.css$/, // For CSS files
                use: ['style-loader', 'css-loader'], // Use style and css loaders
            },
        ]
    },
    devServer: {
        static: path.join(__dirname, 'public'), // Static files directory
        port: 8080, // Webpack Dev Server port
        hot: true, // Hot reloading
    }
};
