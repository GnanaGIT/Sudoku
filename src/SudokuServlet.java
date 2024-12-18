import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SudokuServlet") // URL mapping for the servlet
public class SudokuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Serialization ID for the servlet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[][] grid = new int[9][9];

        // Populate the Sudoku grid from form input
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String paramName = "cell_" + i + "_" + j;
                String value = request.getParameter(paramName);
                grid[i][j] = (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
            }
        }

        // Solve Sudoku puzzle using the SudokuSolver class
        SudokuSolver solver = new SudokuSolver();
        boolean solved = solver.solveSudoku(grid);

        // Pass solved grid and status to the JSP for display
        request.setAttribute("grid", grid);
        request.setAttribute("solved", solved);
        RequestDispatcher dispatcher = request.getRequestDispatcher("solveSudoku.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); // Forward GET requests to POST
    }
}
