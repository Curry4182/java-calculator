package calcproject;

import java.util.Scanner;

import calcproject.engine.CalcExpressionTokenizer;
import calcproject.engine.Calculator;
import calcproject.repository.CalcRecordRepository;
import calcproject.repository.MemoryCalcRecordRepository;
import calcproject.service.CalcManager;
import calcproject.view.console.CalcConsoleView;

public class Main {
	public static void main(String[] args) {
		CalcRecordRepository calcRecordRepository = new MemoryCalcRecordRepository();
		Scanner scanner = new Scanner(System.in);
		CalcConsoleView calcConsoleView = new CalcConsoleView(scanner);
		CalcExpressionTokenizer calcExpressionTokenizer = new CalcExpressionTokenizer();
		Calculator calculator = new Calculator(calcExpressionTokenizer);

		Runnable calcManager = new CalcManager(calcRecordRepository, calcConsoleView, calcConsoleView, calculator);

		calcManager.run();
	}
}
