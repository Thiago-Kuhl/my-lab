//Arrow function
const soma = (a, b) => a + b
console.log(soma(1, 2))

//Arrow function this
const lexico1 = () => console.log(this === exports)
const lexico2 = lexico1.bind({})
lexico1()
lexico2()

//parametros default
function log(texto = 'padrão'){
    console.log(texto)
}

log(undefined)
log(null)
log('sou mais forte')

//Operador rest
function total(...numeros) {
    let total = 0
    numeros.forEach(n => total += n)
    return total
}
console.log(total(2,3,4,5))