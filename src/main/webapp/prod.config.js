const path = require('path');
const miniCss = require('mini-css-extract-plugin');
const TerserPlugin = require("terser-webpack-plugin");
const CssMinimizerPlugin = require("css-minimizer-webpack-plugin");

module.exports = {
    entry: './js/main.js',
    mode: 'production',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'index.bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.m?js$/,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                }]
            },
            {
                test: /\.s[ac]ss$/i,
                use: [
                    miniCss.loader,
                    "css-loader",
                    "sass-loader",
                ],
            },
            {
                test: /\.(png|svg|jpg|jpeg|gif)$/i,
                type: 'asset/resource',
            },
            {
                test: /\.(woff|woff2|eot|ttf|otf)$/i,
                type: 'asset/resource',
            },
        ],
    },
    optimization: {
        minimize: true,
        minimizer: [
            new TerserPlugin(
                {
                    test: /\.js(\?.*)?$/i,
                }
            ),
            new CssMinimizerPlugin(),
        ],
    },
    plugins: [
        new miniCss({
            filename: 'style.bundle.css',
        }),
    ]
};