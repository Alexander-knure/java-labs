package nure;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ImageServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		  try {
			  String category = request.getParameter("category");
			  out.println("<div class=\"text\" align=\"center\"><b>Image: ");
			  out.println(category);
			  out.println("</b></div>");
			  
			  switch(category)
			  {
			  case "City": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/gonkong_kitaj_neboskreby_nochnoj_gorod_ogni_goroda_119347_1920x1080.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Food": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/chay_chashka_korica_limon_chrnyy_fon_sahar_79079_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Cat": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/kot_zima_pushistyj_sneg_99366_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Space": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/uragan_mks_zemlya_oblaka_stihiya_86659_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Car": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/koenigsegg_agera_rs_vid_sboku_osen_derevya_107373_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Bike": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/yamaha_r1_vid_sboku_gorod_104740_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "Lake": 
				  out.println("<img src=\"https://images.wallpaperscraft.ru/image/zvezdnoe_nebo_lodka_otrazhenie_125803_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  case "House": 
				  out.println(" <img src=\"https://images.wallpaperscraft.ru/image/germaniya_arhitektura_krasota_most_oblaka_krasochnye_cveta_trava_zelenaya_dom_doma_otrazhenie_reka_doroga_nebo_gorod_derevya_vid_voda_hdr_58833_1280x720.jpg\" alt=\"sorry, connect is very slow...\" />");
				  break;
			  default:
				  out.println("<div class=\"text\" align=\"center\"><b>Sorry, but you don`t choose image on previous page</b></div>");
			  }
	        } finally {
	        	out.close();  
	        }
	}

}
