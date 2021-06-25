const url = 'http://files.cod3r.com.br/curso-js/funcionarios.json'
const axios = require('axios')

axios.get(url).then((res) => {
    const funcionarios = res.data
    const getFuncionarias = funcionarios => funcionarios.genero === 'F'
    const getChinesas = funcionarias => funcionarias.pais === 'China'
    const getMenorSalario = (funcionaria, funcionarioAtual) => funcionaria.salario < funcionarioAtual.salario ? funcionaria : funcionarioAtual

    const resultado = funcionarios.filter(getFuncionarias).filter(getChinesas).reduce(getMenorSalario)
    console.log(resultado)
})