package br.com.vinicius.outros;

import org.springframework.context.ApplicationContext;

import br.com.vinicius.util.GetContext;

public class Principal {
	
//	@Autowired
//	private static PersonMassGenerator personMassGenerator;
//	@Autowired
//	private static StateMassGenerator stateMassGenerator;
//	@Autowired
//	private static VehicleBrandMassGenerator vehicleBrandMassGenerator;
//	@Autowired
//	private static FileController fileController;

	public static void main(String[] args) {
		
		ApplicationContext context = new GetContext().getContext();
		
		PersonMassGenerator service = context.getBean("personMassGenerator", PersonMassGenerator.class);
		
//		service.print();
	
//		vehicleBrandMassGenerator.gerarMassaMarcaVeic();	
//		stateMassGenerator.gerarMassaEstado();
		
		for (int i = 0; i < 6; i++) {
			service.gerarMassaPessoa();			
		}	
//		
//		fileController.generatingFile();
	}
}