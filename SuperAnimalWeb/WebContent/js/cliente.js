/*  global $ */
$(document).ready(function () {
  $('.date').mask('00/00/0000')
  $('.cpf').mask('000.000.000-00')
  $('.cep').mask('00000-000')
  $('.fixo').mask('(00)0000-0000')
  $('.cel').mask('(00)00000-0000')

  $('section .alert-danger').fadeIn().delay(6000).fadeOut() /* segundos */
  $('section .alert-sucess').fadeIn().delay(6000).fadeOut() /* segundos */
})

function validarNome (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_nome')

  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('cliente_nome-cross').style.display = 'inline'
    document.getElementById('cliente_nome-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity("'" + input.value + "'" + 'não parece um nome')
    label.innerHTML = "'" + input.value + "'" + 'não parece um nome'

    document.getElementById('cliente_nome-cross').style.display = 'inline'
    document.getElementById('cliente_nome-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_nome-cross').style.display = 'none'
    document.getElementById('cliente_nome-check').style.display = 'inline'
  }
  return true
}

function validarSobrenome (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_sobrenome')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('cliente_sobrenome-cross').style.display = 'inline'
    document.getElementById('cliente_sobrenome-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity("'" + input.value + "'" + 'não parece um sobrenome')
    label.innerHTML = "'" + input.value + "'" + 'não parece um sobrenome'

    document.getElementById('cliente_sobrenome-cross').style.display = 'inline'
    document.getElementById('cliente_sobrenome-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_sobrenome-cross').style.display = 'none'
    document.getElementById('cliente_sobrenome-check').style.display = 'inline'
  }
  return true
}

function validarData (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_nascimento')

  var dataSplit = input.value.split('/')

  var dia = dataSplit[0]
  var mes = dataSplit[1]
  var ano = dataSplit[2]

  var novaData = ano + '/' + mes + '/' + dia

  var minDate = new Date('01/01/1917')
  var maxDate = new Date('12/31/2004')

  var dataInput = new Date(novaData)

  if (input.value.length == 0) {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('cliente_nascimento-cross').style.display = 'inline'
    document.getElementById('cliente_nascimento-check').style.display = 'none'

    return false
  }

  if (input.value.length != 10) {
    input.setCustomValidity('Tamanho inválido')
    label.innerHTML = 'Tamanho inválido'

    document.getElementById('cliente_nascimento-cross').style.display = 'inline'
    document.getElementById('cliente_nascimento-check').style.display = 'none'

    return false
  } else {
    if (dataInput >= minDate && dataInput <= maxDate) {
      input.setCustomValidity('')
      label.innerHTML = ''

      document.getElementById('cliente_nascimento-cross').style.display = 'none'
      document.getElementById('cliente_nascimento-check').style.display = 'inline'
    } else {
      input.setCustomValidity('De 01/01/1917 até 12/31/2004')
      label.innerHTML = 'De 01/01/1917 até 31/12/2004'

      document.getElementById('cliente_nascimento-cross').style.display = 'inline'
      document.getElementById('cliente_nascimento-check').style.display = 'none'

      return false
    }
  }
  return true
}

function validarGenero (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_genero')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_genero-cross').style.display = 'inline'
    document.getElementById('cliente_genero-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('cliente_genero-cross').style.display = 'none'
    document.getElementById('cliente_genero-check').style.display = 'inline'
  }
  return true
}

function validarCPF (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_cpf')
  var c

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'

    document.getElementById('cliente_cpf-cross').style.display = 'inline'
    document.getElementById('cliente_cpf-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'

    document.getElementById('cliente_cpf-cross').style.display = 'inline'
    document.getElementById('cliente_cpf-check').style.display = 'none'

    return false
  } else {
    if ((c = input.value.replace(/[^\d]/g, "")).length != 11) {
      input.setCustomValidity('CPF inválido')
      label.innerHTML = 'CPF inválido'

      document.getElementById('cliente_cpf-cross').style.display = 'inline'
      document.getElementById('cliente_cpf-check').style.display = 'none'

      return false
    }

    if (c == '00000000000' || c == '11111111111' || c == '22222222222' || c == '33333333333' || c == '44444444444' || c == '55555555555' || c == '66666666666' || c == '77777777777' || c == '88888888888' || c == '99999999999') {
      input.setCustomValidity('CPF inválido')
      label.innerHTML = 'CPF inválido'

      document.getElementById('cliente_cpf-cross').style.display = 'inline'
      document.getElementById('cliente_cpf-check').style.display = 'none'
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

      document.getElementById('cliente_cpf-cross').style.display = 'inline'
      document.getElementById('cliente_cpf-check').style.display = 'none'
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

      document.getElementById('cliente_cpf-cross').style.display = 'inline'
      document.getElementById('cliente_cpf-check').style.display = 'none'
      return false
    }
  }

  input.setCustomValidity('')
  label.innerHTML = ''

  document.getElementById('cliente_cpf-cross').style.display = 'none'
  document.getElementById('cliente_cpf-check').style.display = 'inline'

  return true
}

function validarCRMV (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_crmv')

  var c = input.value.replace(/[^\d]/g, '')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (c.length != 6 || c == '000000' || c == '111111' || c == '222222' || c == '333333' || c == '444444' || c == '555555' || c == '666666' || c == '777777' || c == '888888' || c == '999999' || c == '123456') {
    input.setCustomValidity('CRMV inválido*')
    label.innerHTML = 'CRMV inválido*'

    document.getElementById('cliente_crmv-cross').style.display = 'inline'
    document.getElementById('cliente_crmv-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('CRMV inválido*')
    label.innerHTML = 'CRMV inválido*'

    document.getElementById('cliente_crmv-cross').style.display = 'inline'
    document.getElementById('cliente_crmv-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_crmv-cross').style.display = 'none'
    document.getElementById('cliente_crmv-check').style.display = 'inline'
  }

  return true
}

function validarCEP (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_cep')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_cep-cross').style.display = 'inline'
    document.getElementById('cliente_cep-check').style.display = 'none'
    document.getElementById('cliente_cep-warning').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_cep-cross').style.display = 'inline'
    document.getElementById('cliente_cep-check').style.display = 'none'
    document.getElementById('cliente_cep-warning').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_cep-cross').style.display = 'none'
    document.getElementById('cliente_cep-check').style.display = 'inline'
    document.getElementById('cliente_cep-warning').style.display = 'none'
  }
  return true
}

function validarEndereco (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_endereco')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_endereco-cross').style.display = 'inline'
    document.getElementById('cliente_endereco-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'

    document.getElementById('cliente_endereco-cross').style.display = 'inline'
    document.getElementById('cliente_endereco-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_endereco-cross').style.display = 'none'
    document.getElementById('cliente_endereco-check').style.display = 'inline'
  }
  return true
}

function validarBairro (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_bairro')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_bairro-cross').style.display = 'inline'
    document.getElementById('cliente_bairro-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_bairro-cross').style.display = 'inline'
    document.getElementById('cliente_bairro-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_bairro-cross').style.display = 'none'
    document.getElementById('cliente_bairro-check').style.display = 'inline'
  }
  return true
}

function validarNumero (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_numero')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_numero-cross').style.display = 'inline'
    document.getElementById('cliente_numero-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_numero-cross').style.display = 'inline'
    document.getElementById('cliente_numero-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_numero-cross').style.display = 'none'
    document.getElementById('cliente_numero-check').style.display = 'inline'
  }
  return true
}

function validarComplemento (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_complemento')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_complemento-cross').style.display = 'inline'
    document.getElementById('cliente_complemento-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_complemento-cross').style.display = 'none'
    document.getElementById('cliente_complemento-check').style.display = 'inline'
  }
  return true
}

function validarCidade (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_cidade')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_cidade-cross').style.display = 'inline'
    document.getElementById('cliente_cidade-check').style.display = 'none'

    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'

    document.getElementById('cliente_cidade-cross').style.display = 'inline'
    document.getElementById('cliente_cidade-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_cidade-cross').style.display = 'none'
    document.getElementById('cliente_cidade-check').style.display = 'inline'
  }
  return true
}

function validarEstado (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_estado')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_estado-cross').style.display = 'inline'
    document.getElementById('cliente_estado-check').style.display = 'none'

    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('cliente_estado-cross').style.display = 'none'
    document.getElementById('cliente_estado-check').style.display = 'inline'
  }
  return true
}

function validarEmail (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_email')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_email-cross').style.display = 'inline'
    document.getElementById('cliente_email-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity("'" + input.value + "'" + 'não parece um email')
    label.innerHTML = "'" + input.value + "'" + 'não parece um email'
    document.getElementById('cliente_email-cross').style.display = 'inline'
    document.getElementById('cliente_email-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('cliente_email-cross').style.display = 'none'
    document.getElementById('cliente_email-check').style.display = 'inline'
  }
  return true
}

function validarFixo (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_fixo')

  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_fixo-cross').style.display = 'inline'
    document.getElementById('cliente_fixo-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''

    document.getElementById('cliente_fixo-cross').style.display = 'none'
    document.getElementById('cliente_fixo-check').style.display = 'inline'
  }
  return true
}

function validarCel (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_cel')
  // Quebrar a string removendo os espaços em branco para saber se existe algum caractere
  if (input.value.trim().split(/\s+/g) == "") {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_cel-cross').style.display = 'inline'
    document.getElementById('cliente_cel-check').style.display = 'none'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Formato inválido')
    label.innerHTML = 'Formato inválido'
    document.getElementById('cliente_cel-cross').style.display = 'inline'
    document.getElementById('cliente_cel-check').style.display = 'none'
    return false
  } else {
    input.setCustomValidity('')
    label.innerHTML = ''
    document.getElementById('cliente_cel-cross').style.display = 'none'
    document.getElementById('cliente_cel-check').style.display = 'inline'
  }
  return true
}

// https://www.aspsnippets.com/Articles/Password-Strength-validation-example-using-JavaScript-and-jQuery.aspx
function validarSenha (input) { // eslint-disable-line no-unused-vars
  var label = document.getElementById('label-cliente_senha')

  // TextBox left blank.
  if (input.value.length == 0) {
    input.setCustomValidity('Obrigatório*')
    label.innerHTML = 'Obrigatório*'
    document.getElementById('cliente_senha-cross').style.display = 'inline'
    document.getElementById('cliente_senha-check').style.display = 'none'
    document.getElementById('cliente_senha-warning').style.display = 'none'
    return false
  } else if (input.value.length != 8) {
    input.setCustomValidity('Deve ter 8 caracteres')
    label.innerHTML = 'Deve ter 8 caracteres'
    document.getElementById('cliente_senha-cross').style.display = 'inline'
    document.getElementById('cliente_senha-check').style.display = 'none'
    document.getElementById('cliente_senha-warning').style.display = 'none'
    label.style.color = 'red'
    return false
  } else if (input.validity.patternMismatch) {
    input.setCustomValidity('Caracteres especiais válidos: $@$!%*#?&')
    label.innerHTML = 'Caracteres especiais válidos: $@!%*#?&'
    document.getElementById('cliente_senha-cross').style.display = 'inline'
    document.getElementById('cliente_senha-check').style.display = 'none'
    document.getElementById('cliente_senha-warning').style.display = 'none'
    label.style.color = 'gray'
    return false
  } else {
    // Regular Expressions.
    var regex = []
    regex.push('[A-Z]') // Uppercase Alphabet.
    regex.push('[a-z]') // Lowercase Alphabet.
    regex.push('[0-9]') // Digit.
    regex.push('[$@$!%*#?&]') // Special Character.

    var passed = 0

    // Validate for each Regular Expression.
    for (var i = 0; i < regex.length; i++) {
      if (new RegExp(regex[i]).test(input.value)) {
        passed++
      }
    }

    // Validate for length of Password.
    if (passed > 2 && input.value.length == 8) {
      passed++
    }

    // Display status.
    var color = ''
    var strength = ''
    switch (passed) {
      case 0:
      case 1:
        strength = 'Ruim'
        color = 'red'
        document.getElementById('cliente_senha-cross').style.display = 'inline'
        document.getElementById('cliente_senha-check').style.display = 'none'
        document.getElementById('cliente_senha-warning').style.display = 'none'

        input.setCustomValidity('Segurança: Muito Fraca')
        break
      case 2:
        strength = 'Boa'
        color = 'darkorange'
        document.getElementById('cliente_senha-cross').style.display = 'none'
        document.getElementById('cliente_senha-check').style.display = 'none'
        document.getElementById('cliente_senha-warning').style.display = 'inline'

        input.setCustomValidity('')
        break
      case 3:
      case 4:
        strength = 'Muito boa'
        color = 'green'

        document.getElementById('cliente_senha-cross').style.display = 'none'
        document.getElementById('cliente_senha-check').style.display = 'inline'
        document.getElementById('cliente_senha-warning').style.display = 'none'

        input.setCustomValidity('')
        break
      case 5:
        strength = 'Ótima'
        color = 'darkgreen'

        document.getElementById('cliente_senha-cross').style.display = 'none'
        document.getElementById('cliente_senha-check').style.display = 'inline'
        document.getElementById('cliente_senha-warning').style.display = 'none'

        input.setCustomValidity('')
        break
    }
    label.innerHTML = 'Segurança: ' + strength
    label.style.color = color
  }
}
