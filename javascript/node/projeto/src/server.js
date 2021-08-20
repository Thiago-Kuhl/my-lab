const port = 3000;

const express = require('express');
const bodyParser = require('body-parser')
const app = express();
const db = require('./db')

app.use(bodyParser.json({extended: true}))

app.get('/produtos', (req, res, next) => {
    res.send(db.getProdutos())
})

app.get('/produtos/:id', (req, res, next) => {
    res.send(db.getProduto(req.params.id))
})

app.post('/produtos', (req, res, next) => {
    const { name, value } = req.body
    const produto = db.salvarProduto({
        name,
        value
    })
    res.send(produto)
})

app.put('/produtos/:id', (req, res, next) => {
    console.log(req.body)
    const { name, value } = req.body
    const produto = db.salvarProduto({
        id: req.params.id,
        name,
        value
    })
    res.send(produto)
})

app.delete('/produtos/:id', (req, res, next) => {
    const produto = db.excluirProduto(req.params.id)
    res.send(produto)
})


app.listen(port, () => {
    console.log(`Servidor está executando na porta ${port}.`)
})