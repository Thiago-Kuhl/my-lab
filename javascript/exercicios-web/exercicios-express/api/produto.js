module.exports = (app, texto) => {
    function salvar(req, res) {
        res.send('Produto > Salvar ' + texto);
    }

    function obter(req, res) {
        res.send('Produto > Obter ' + texto);
    }

    app.get('/produtos', obter)
    app.post('/produtos', salvar)

    return {salvar, obter}
} 