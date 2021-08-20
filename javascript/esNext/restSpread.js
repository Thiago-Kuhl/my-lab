// operador ... rest(juntar) / spred(espalhar)
//user rest como parâmetro de função

//usar spred com objeto 
const funcionario = { nome: 'Maria', salario: 12348.89 }
const clone = { ativo: true, ...funcionario }
console.log(clone)

//usar spread com array
const grupoA = ['João', 'Pedro', 'Maria']
const grupoB = ['Maria', 'Rafaela', ...grupoA]
console.log(grupoB)