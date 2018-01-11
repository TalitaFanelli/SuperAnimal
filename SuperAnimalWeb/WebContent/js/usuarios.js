/*  global $ */
$(document).ready(function () {
  $("input[type='radio']").val(['animal']).attr('checked', true) /* CHECK RADIOS BUTTONS */
  $('section .cliente').hide()
  $('section .veterinario').hide()
  $('section .animal').show()

  $('#tabela-animal').DataTable({
    responsive: true,
    'language': {
      'sLengthMenu': 'Mostrar _MENU_ registros por página',
      'sZeroRecords': 'Nenhum registro encontrado',
      'sInfo': 'Mostrando página _PAGE_ de _PAGES_',
      'infoEmpty': '',
      'infoFiltered': '',
      'sEmptyTable': 'Nenhum dado foi inserido ainda',
      'sSearch': 'Pesquisar: ',
      'searchPlaceholder': 'PESQUISAR',

      'oPaginate': {
        'sPrevious': 'Página anterior',
        'sNext': 'Próxima página',
        'sFirst': 'Primeira página',
        'sLast': 'Última página'
      }
    }
  })

  $('#tabela-cliente').DataTable({
    responsive: true,
    'language': {
      'sLengthMenu': 'Mostrar _MENU_ registros por página',
      'sZeroRecords': 'Nenhum registro encontrado',
      'sInfo': 'Mostrando página _PAGE_ de _PAGES_',
      'infoEmpty': '',
      'infoFiltered': '',
      'sEmptyTable': 'Nenhum dado foi inserido ainda',
      'sSearch': 'Pesquisar: ',
      'searchPlaceholder': 'PESQUISAR',

      'oPaginate': {
        'sPrevious': 'Página anterior',
        'sNext': 'Próxima página',
        'sFirst': 'Primeira página',
        'sLast': 'Última página'
      }
    }
  })

  $('#tabela-veterinario').DataTable({
    responsive: true,
    'language': {
      'sLengthMenu': 'Mostrar _MENU_ registros por página',
      'sZeroRecords': 'Nenhum registro encontrado',
      'sInfo': 'Mostrando página _PAGE_ de _PAGES_',
      'infoEmpty': '',
      'infoFiltered': '',
      'sEmptyTable': 'Nenhum dado foi inserido ainda',
      'sSearch': 'Pesquisar: ',
      'searchPlaceholder': 'PESQUISAR',

      'oPaginate': {
        'sPrevious': 'Página anterior',
        'sNext': 'Próxima página',
        'sFirst': 'Primeira página',
        'sLast': 'Última página'
      }
    }
  })

  /* MOSTRAR A SECTION DE ACORDO COM O RADIO BUTTON SELECIONADO */
  $("input[type='radio']").click(function () {
    if ($(this).attr('value') === 'animal') {
      $('section .animal').show()
    } else {
      $('section .animal').hide()
    }

    if ($(this).attr('value') === 'cliente') {
      $('section .cliente').show()
    } else {
      $('section .cliente').hide()
    }

    if ($(this).attr('value') === 'veterinario') {
      $('section .veterinario').show()
    } else {
      $('section .veterinario').hide()
    }
  })
})

/* global confirm */
function confirmacao () { // eslint-disable-line no-unused-vars
  if (confirm('Essa operação é irreversível. Deseja continuar?')) {
    return true
  } else {
    return false
  }
}
