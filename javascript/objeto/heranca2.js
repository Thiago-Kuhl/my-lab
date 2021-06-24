// Cadeia de protótipos (prototype chain)

const avo = {attr1: 'A' }
const pai = {__proto__: avo, attr2: 'B', attr3: '3'}
const filho = {__proto__: pai, attr3: 'C'}

console.log(filho.attr1, filho.attr2, filho.attr3, filho.attr4)

const carro = {
    velAtual: 0,
    velMax: 200,
    aceleraMais(delta){
        if (this.velAtual + delta <= this.velMax) {
            this.velAtual += delta
        } else {
            this.velAtual = this.velMax
        }
    },
    status() {
        return `${this.velAtual}KM/h de ${this.velMax}`
    }
}

const ferrari = {
    'modelo' : 'F40',
    velMax: 324, //shadowing
    __proto__: carro
}

const volvo = {
    'modelo' : 'V40',
    status() {
        return `${this.modelo}: ${super.status()}`
    }
}

Object.setPrototypeOf(volvo, carro)

console.log(ferrari)
console.log(volvo)

volvo.aceleraMais(100)
console.log(volvo.status())

ferrari.aceleraMais(300)
console.log(ferrari.status())