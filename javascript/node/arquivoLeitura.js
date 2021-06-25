const fs = require('fs')

//sincrono...
const caminho = __dirname + '/arquivo.json'

const conteudo = fs.readFileSync(caminho, 'utf8')

console.log(conteudo)

//assincrono

fs.readFile(caminho, 'utf8', (err, conteudo) => {
    if (err == null) {
        const config = JSON.parse(conteudo)
        console.log(`${config.db.host}:${config.db.port}`)
    } else {
        console.log(err)
    }
})

const config = require('./arquivo.json')
console.log(config.db)

fs.readdir(__dirname, (err, arquivos) => {
    console.log('Conteúdo da pasta...')
    console.log(arquivos)
})