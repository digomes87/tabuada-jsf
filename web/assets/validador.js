/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validarCampos() {
  // Obter os valores dos campos
  const matricula = document.getElementById("matricula").value;
  const nome = document.getElementById("nome").value;

  // Validar a matrícula
  if (isNaN(matricula) || matricula === "") {
    // Exibir mensagem de erro
    alert("Matrícula inválida!");
    return false;
  }

  // Validar o nome
  if (nome === "") {
    // Exibir mensagem de erro
    alert("Nome inválido!");
    return false;
  }

  // Se todos os campos forem válidos, retornar true
  return true;
}
