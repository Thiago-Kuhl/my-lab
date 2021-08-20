function gerarNumeros(min, max, numerosProibidos) {
    if (min > max) [max, min] = [min, max]

    return new Promise((resolve, reject) => {
        const fator = max - min + 1
        const random = parseInt(Math.random() * fator) + min
        if (numerosProibidos.includes(random)) {
            reject('Números repetidos')
        } else {
            resolve(random)
        }
    })
}

async function gerarMegaSena(qtdNumeros, tentativas = 1){
    try {
        const numeros = []
        for(let _ of Array(qtdNumeros).fill()){
            numeros.push(await gerarNumeros(1, 60, numeros))
        }
        return numeros
    } catch (err) {
        if(tentativas > 10) {
            throw 'Que chatoo!'
        } else {
            gerarMegaSena(qtdNumeros, tentativas + 1)
        }
    }

}

gerarMegaSena(15)
    .then(console.log)
    .catch(console.log)
