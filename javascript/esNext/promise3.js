function gerarNumeros(min, max) {
    if (min > max) {
        [max, min] = [min, max]    
    }

    return new Promise((resolve, reject) => {
        const fator = max - min + 1
        const random = parseInt(Math.random() * fator) + min
        resolve(random)
    })
}

gerarNumeros(10, 60)
    .then(num => num * 10)
    .then(numX10 => `O número gerado foi ${numX10}`)
    .then(console.log)