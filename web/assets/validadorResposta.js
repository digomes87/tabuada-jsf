/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validarResposta() {
        var questoesRespondidas = parseInt('<%= request.getSession().getAttribute("questoesRespondidas") %>');
        questoesRespondidas++;
        '<%= request.getSession().setAttribute("questoesRespondidas", questoesRespondidas) %>';

        var totalQuestoes = parseInt('<%= request.getSession().getAttribute("totalQuestoes") %>');

        if (questoesRespondidas >= totalQuestoes) {
            window.location.href = "resultado.jsp";
            return false;
        }
        return true;

