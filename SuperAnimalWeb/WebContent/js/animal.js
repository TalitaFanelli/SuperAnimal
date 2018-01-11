/*  global $ */
$(document).ready(function () {
  $('.date').mask('00/00/0000')
  $('.cpf').mask('000.000.000-00')
})

function validarNome (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-animal_nome')

  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('animal_nome-cross').style.display = 'inline'
    document.getElementById('animal_nome-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity("'" + input.value + "'" + 'não parece um nome')
    label.innerHTML = "'" + input.value + "'" + 'não parece um nome'

    document.getElementById('animal_nome-cross').style.display = 'inline'
    document.getElementById('animal_nome-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('animal_nome-cross').style.display = 'none'
    document.getElementById('animal_nome-check').style.display = 'inline'
  }
  return true
}

function validarSobrenome (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-animal_sobrenome')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('animal_sobrenome-cross').style.display = 'inline'
    document.getElementById('animal_sobrenome-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity("'" + input.value + "'" + 'não parece um nome')
    label.innerHTML = "'" + input.value + "'" + 'não parece um nome'

    document.getElementById('animal_sobrenome-cross').style.display = 'inline'
    document.getElementById('animal_sobrenome-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('animal_sobrenome-cross').style.display = 'none'
    document.getElementById('animal_sobrenome-check').style.display = 'inline'
  }
  return true
}

function validarSexo (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-animal_sexo')

  if (input.value == '') {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('animal_sexo-cross').style.display = 'inline'
    document.getElementById('animal_sexo-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('animal_sexo-cross').style.display = 'none'
    document.getElementById('animal_sexo-check').style.display = 'inline'
  }

  return true
}

function validarNascimento (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-animal_nascimento')

  var dataSplit = input.value.split('/')

  var dia = dataSplit[0]
  var mes = dataSplit[1]
  var ano = dataSplit[2]

  var novaData = ano + '/' + mes + '/' + dia

  var minDate = new Date('01/01/1997')
  var maxDate = new Date()

  var dataInput = new Date(novaData)

  if (input.value.length == 0) {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('animal_nascimento-cross').style.display = 'inline'
    document.getElementById('animal_nascimento-check').style.display = 'none'

    return false
  }

  if (input.value.length != 10) {
    input.setCustomValidity('Tamanho inválido')
    label.innerHTML = 'Tamanho inválido'

    document.getElementById('animal_nascimento-cross').style.display = 'inline'
    document.getElementById('animal_nascimento-check').style.display = 'none'

    return false
  } else {
    if (dataInput >= minDate && dataInput <= maxDate) {

      input.setCustomValidity('')
      label.innerHTML = ''

      document.getElementById('animal_nascimento-cross').style.display = 'none'
      document.getElementById('animal_nascimento-check').style.display = 'inline'
    } else {
      input.setCustomValidity('De 01/01/1997 até hoje')
      label.innerHTML = 'De 01/01/1997 até hoje'

      document.getElementById('animal_nascimento-cross').style.display = 'inline'
      document.getElementById('animal_nascimento-check').style.display = 'none'

      return false
    }
  }

  calcularIdade(dataInput)
  return true
}

// https://codepen.io/Codeman12323/pen/HqCyw

function calcularIdade (dataInput) { // eslint-disable-line no-unused-vars

  var today = new Date()

  var differenceInMilisecond = today.valueOf() - dataInput.valueOf()

  var yearAge = Math.floor(differenceInMilisecond / 31536000000)
  var dayAge = Math.floor((differenceInMilisecond % 31536000000) / 86400000)

  /* if ((today.getMonth() == dataInput.getMonth()) && (today.getDate() == dataInput.getDate())) {
        alert("Happy B'day!!!")
    } */

  var monthAge = Math.floor(dayAge / 30)

  dayAge = dayAge % 30

  if (isNaN(yearAge) || isNaN(monthAge) || isNaN(dayAge)) {
    document.getElementById('animal_idade').value = 'Invalid dataInput - Please try again!'
  } else {
    document.getElementById('calculo_ano').value = yearAge
    document.getElementById('calculo_mes').value = monthAge
  }
}

function validarEspecie (input) {
  var label = document.getElementById('label-animal_especie')

  if (input.value == '') {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('animal_especie-cross').style.display = 'inline'
    document.getElementById('animal_especie-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('animal_especie-cross').style.display = 'none'
    document.getElementById('animal_especie-check').style.display = 'inline'
  }

  return true
}

function validarRaca (input) {
  var label = document.getElementById('label-animal_raca')

  if (input.value.trim().split(/\s+/g) == '') {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('animal_raca-cross').style.display = 'inline'
    document.getElementById('animal_raca-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'

    document.getElementById('animal_raca-cross').style.display = 'inline'
    document.getElementById('animal_raca-check').style.display = 'none'
    return false
  } else {
    var getInput = input.value
    var inputArray = getInput.trim().split(/\s+/g)
    var inputFinal = inputArray.join(' ')

    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('animal_raca-cross').style.display = 'none'
    document.getElementById('animal_raca-check').style.display = 'inline'
  }

  return inputFinal
}

function validarPelagem (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-animal_pelagem')

  if (input.value.trim().split(/\s+/g) == '') {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('animal_pelagem-cross').style.display = 'inline'
    document.getElementById('animal_pelagem-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'

    document.getElementById('animal_pelagem-cross').style.display = 'inline'
    document.getElementById('animal_pelagem-check').style.display = 'none'
    return false
  } else {
    var getInput = input.value
    var inputArray = getInput.trim().split(/\s+/g)
    var inputFinal = inputArray.join(' ')

    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('animal_pelagem-cross').style.display = 'none'
    document.getElementById('animal_pelagem-check').style.display = 'inline'
  }

  return inputFinal
}

function validarCPF (input) { // eslint-disable-line no-unused-vars
	  var label = document.getElementById('label-animal_dono')
	  var c

	  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
	  if (input.value.trim().split(/\s+/g) == "") {
	    input.setCustomValidity('Obrigatório*')
	    label.innerHTML = 'Obrigatório*'

	    document.getElementById('animal_dono-cross').style.display = 'inline'
	    document.getElementById('animal_dono-check').style.display = 'none'

	    return false
	  } else if (input.validity.patternMismatch) {
	    input.setCustomValidity('Formato inválido')
	    label.innerHTML = 'Formato inválido'

	    document.getElementById('animal_dono-cross').style.display = 'inline'
	    document.getElementById('animal_dono-check').style.display = 'none'

	    return false
	  } else {
	    if ((c = input.value.replace(/[^\d]/g, "")).length != 11) {
	      input.setCustomValidity('CPF inválido')
	      label.innerHTML = 'CPF inválido'

	      document.getElementById('animal_dono-cross').style.display = 'inline'
	      document.getElementById('animal_dono-check').style.display = 'none'

	      return false
	    }

	    if (c == '00000000000' || c == '11111111111' || c == '22222222222' || c == '33333333333' || c == '44444444444' || c == '55555555555' || c == '66666666666' || c == '77777777777' || c == '88888888888' || c == '99999999999') {
	      input.setCustomValidity('CPF inválido')
	      label.innerHTML = 'CPF inválido'

	      document.getElementById('animal_dono-cross').style.display = 'inline'
	      document.getElementById('animal_dono-check').style.display = 'none'
	      return false
	    }

	    var r
	    var s = 0

	    for (var i = 1; i <= 9; i++) {
	      s = s + parseInt(c[i - 1]) * (11 - i)

	      r = (s * 10) % 11
	    }

	    if ((r == 10) || (r == 11)) {
	      r = 0
	    }

	    if (r != parseInt(c[9])) {
	      input.setCustomValidity('CPF inválido')
	      label.innerHTML = 'CPF inválido'

	      document.getElementById('animal_dono-cross').style.display = 'inline'
	      document.getElementById('animal_dono-check').style.display = 'none'
	      return false
	    }

	    s = 0

	    for (i = 1; i <= 10; i++) {
	      s = s + parseInt(c[i - 1]) * (12 - i)

	      r = (s * 10) % 11
	    }

	    if ((r == 10) || (r == 11)) {
	      r = 0
	    }

	    if (r != parseInt(c[10])) {
	      input.setCustomValidity('CPF inválido')
	      label.innerHTML = 'CPF inválido'

	      document.getElementById('animal_dono-cross').style.display = 'inline'
	      document.getElementById('animal_dono-check').style.display = 'none'
	      return false
	    }
	  }

	  input.setCustomValidity('')
	  label.innerHTML = ''

	  document.getElementById('animal_dono-cross').style.display = 'none'
	  document.getElementById('animal_dono-check').style.display = 'inline'

	  return true
	}
