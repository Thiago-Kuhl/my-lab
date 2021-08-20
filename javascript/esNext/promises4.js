function gerarNumeros(min, max, tempo) {
    if (min > max) {
        [max, min] = [min, max]
    }

    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const fator = max - min + 1
            const random = parseInt(Math.random() * fator) + min
            resolve(random)
        }, tempo)
    })
}

function gerarVariosNums() {
    return Promise.all([
        gerarNumeros(10, 50, 1000),
        gerarNumeros(10, 50, 2000),
        gerarNumeros(10, 50, 3000),
        gerarNumeros(10, 50, 4000),
        gerarNumeros(10, 50, 5000),
        gerarNumeros(10, 50, 6000)
    ])
}

console.time('promise')
gerarVariosNums()
    .then(numeros => console.log(numeros))
    .then(() => {
            console.timeEnd('promise')
        })
