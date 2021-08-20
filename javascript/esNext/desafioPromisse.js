const fs = require('fs');
const path = require('path');
function lerArquivo(path) {
    return new Promise((resolve, reject) => {
        fs.readFile(path, 'utf8', (err, conteudo) => {
            if (err == null) {
                resolve(conteudo)
            } else{
                reject(err)
            }
        })
    })
}

const file_path = path.join(__dirname + '/dados.txt')
lerArquivo(file_path).then(console.log)