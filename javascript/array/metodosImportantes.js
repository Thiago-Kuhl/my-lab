const pilotos = ['Vettel', 'Alonso', 'Raikkone', 'Massa']

pilotos.pop() //massa quebrou o carro
console.log(pilotos)

pilotos.push('Verstappen') //Adiciona piloto ao final do array
console.log(pilotos)

pilotos.shift() //remove o primeiro indice do piloto
console.log(pilotos)

pilotos.unshift('Hamiltom') //Adiciona um piloto na primeira posição do array
console.log(pilotos)

// splice pode adicionar ou remover elementos do array

//adicionar
pilotos.splice(2,0, 'Bottas', 'Massa')
console.log(pilotos)

//remover
pilotos.splice(3, 1) //Quebrou novamente
console.log(pilotos)

//criar novo array com slice
const algunsPilotos1 = pilotos.slice(2) //novo array
console.log(algunsPilotos1)

const algunsPilotos2 = pilotos.slice(1, 4)
console.log(algunsPilotos2)

