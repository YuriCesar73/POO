//package negocio;
//
//import exceptions.EmpregadoNaoTemSubordinadoException;
//
//public class Empresa {
//	
//	private Chefe chefes[];
//	private Chefe antonio;
//	
//	public Empresa() {
//	    this.chefes=new Chefe[10];
//		this.antonio=new Chefe("Sr. Antonio");
//	}
//	
//	public void addChefes(Chefe chefe, int pos) {
//		this.chefes[pos]=chefe;
//	}
//	
//	public void addSubordinado(Chefe chefe, Pessoa subordinado, int pos) throws EmpregadoNaoTemSubordinadoException {
//		chefe.addSubordinado(subordinado, pos);
//	}
//	
//	public void listarPessoas() throws EmpregadoNaoTemSubordinadoException {
//		this.antonio.listarSubordinados();
//	}
//	
//	public void listarChefes() {
//		for (int i = 0; i < chefes.length; i++) {
//			Chefe chefe = chefes[i];
//			System.out.println(chefe.getNome());
//			
//		}
//	}
//	
//
//}
