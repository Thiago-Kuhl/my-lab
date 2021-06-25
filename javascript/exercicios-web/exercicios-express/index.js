const express = require('express');
const app = express();
const saudacao = require('./middlewares/mid')
const usuarioAPI = require('./api/usuarios')
const bodyParser = require('body-parser')
require('./api/produto')(app, 'com param!')

app.get('/usuario', usuarioAPI.obter)
app.post('/usuario', usuarioAPI.salvar)

app.use(saudacao('Thiago'))
app.use(bodyParser.text())
app.use(bodyParser.json())
app.use((req, res, next) => {
    console.log('Antes...')
    next()
})


app.get('/clientes/relatorio', (req, res) => {
    res.send(`Cliente relatório: completo = ${req.query.completo} ano = ${req.query.ano} `)
})

app.post('/corpo', (req, res) => {
    // let corpo = ''
    // req.on('data', (parte) => {
    //     corpo += parte
    //     res.send(corpo)
    // })
    res.send(req.body)
})

app.get('/clientes/:id', (req, res) => {
    res.send(`Cliente ${req.params.id} selecionado.`)
})


app.get('/opa', (req, res, next) => {
    console.log('Durante...')
    res.json([
        {id: 7, name: 'Carlos', 'position': 1},
        {id: 5, name: 'Dean', 'position': 2},
        {id: 2, name: 'Dan', 'position': 3}
    ])
    next()
    // res.json({
    //     name: 'Ipad',
    //     price: 12345.99, 
    //     discount: 0.12
    // })
    // res.send('I\'m <b>goog!</b>')

})

app.use((req, res) => {
    console.log('Depois...')
})

app.listen(3000, () => console.log('Backend rodando...'))