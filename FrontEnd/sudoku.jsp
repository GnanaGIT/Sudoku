<%@ page import="java.util.*" %>
<html>
<head><title>Solved Sudoku</title></head>
<body>
    <h1>Solved Sudoku</h1>
    <% 
        int[][] grid = (int[][]) request.getAttribute("grid");
        boolean solved = (boolean) request.getAttribute("solved");
        if (solved) {
    %>
    <table border="1">
        <% for (int i = 0; i < 9; i++) { %>
            <tr>
                <% for (int j = 0; j < 9; j++) { %>
                    <td><%= grid[i][j] %></td>
                <% } %>
            </tr>
        <% } %>
    </table>
    <% } else { %>
        <p>Sudoku cannot be solved!</p>
    <% } %>
</body>
</html>
