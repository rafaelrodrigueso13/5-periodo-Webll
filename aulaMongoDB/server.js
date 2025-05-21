import { createApp } from './app.js'

const PORT = process.env.PORT || 3000;

createApp()
    .then(app => app.listen(PORT, () => {
        console.log('Servidor rodando na porta: ', PORT);
    }))
    .catch(error => {
        console.log('Error detalhamento:', error);
    }) 
