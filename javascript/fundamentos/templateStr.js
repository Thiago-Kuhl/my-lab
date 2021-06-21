const nome  = 'Thiago'
const concatenacao = "Olá " + nome + '!'
const template = `
    Olá,
    ${nome}!
`

console.log(template)

const up = str => str.toUpperCase()

console.log(`Ei.... ${up('cuidado')} !`)