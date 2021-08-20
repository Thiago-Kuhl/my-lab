function funcionarOuNao(valor, chanceDeErro) {
    return new Promise((resolve, reject) => {
        try {
            if(Math.random() < chanceDeErro) {
                reject('Ocorreu um erro')
            } else {
                resolve(valor)
            }
        } catch (err) {
            reject(err)
        }
    })
}

funcionarOuNao('Testando...', 0.9)
    .then(console.log)
    .catch(console.error)