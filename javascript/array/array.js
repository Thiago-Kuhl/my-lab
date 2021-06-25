console.log(typeof Array, typeof new Array, typeof [])

let aprovados = new Array('Bia', 'Carlos', 'Daniel')
console.log(aprovados)

aprovados = ['Bia', 'Carlos', 'Daniel']
console.log(aprovados[0])
console.log(aprovados[1])
console.log(aprovados[2])
console.log(aprovados[3])
aprovados[3] = 'Paulo'
console.log(aprovados[3])
aprovados.push('Thiago')
console.log(aprovados.length)
aprovados[9] = 'Rafael'
console.log(aprovados)
console.log(aprovados.length)

console.log(aprovados)
aprovados.sort()
console.log(aprovados.sort())

delete aprovados[1]
console.log(aprovados[1], aprovados[2])

aprovados = ['Bia', 'Carlos', 'Daniel']
console.log(aprovados)
aprovados.splice(1,1)
console.log(aprovados)