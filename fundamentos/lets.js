var numberVar = 1 //escopo global e funcao
let numberLet = 1 //escopo global, funcao e bloco

{
  let numberLet = 2
  console.log(numberLet)
}

console.log(numberLet)
