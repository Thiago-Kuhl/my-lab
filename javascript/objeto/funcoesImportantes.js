const pessoa = {
    nome: 'Rebeca',
    idade: 44,
    peso: 65.7
}

console.log(Object.keys(pessoa))
console.log(Object.values(pessoa))
console.log(Object.entries(pessoa))

Object.entries(pessoa).forEach(([chave, valor]) => {
    console.log(`${chave} : ${valor}`)
})

Object.defineProperty(pessoa, 'dataNascimento', {
    enumerable: true,
    writable: false,
    value: '03-09-2000'
})
pessoa.dataNascimento = '04-09-2000'
console.log(pessoa.dataNascimento)
console.log(Object.keys(pessoa))

// Object.assigne (ES6)
const dest = { a: 1 }
const o1 = { b: 2 }
const o2 = { c: 3, a: 4 }
const obj = Object.assign(dest, o1, o2)
console.log(obj)

Object.freeze(obj)
obj.c = 123
console.log(obj)