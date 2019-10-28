/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.java8;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "MasterMindServlet", value = "/index")
public class MasterMindServlet extends HttpServlet {

    MasterMind masterMind;

    public void playMasterMind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameInstance instance = new GameInstance("web player");
        masterMind.play(instance,request.getParameter("guess"));

        request.setAttribute("hiddenPhrase",masterMind.hiddenPhrase);
        request.setAttribute("randomPhrase",masterMind.randomPhrase);
        request.setAttribute("guess", request.getParameter("guess"));
        request.setAttribute("partials", masterMind.partials);
        request.setAttribute("exacts", masterMind.exacts);
        request.setAttribute("correct", masterMind.correct);
        request.setAttribute("lives", masterMind.lives);
        request.setAttribute("previousGuesses", masterMind.previousGuesses);
        System.out.println(masterMind.randomPhrase);

        request.getSession().setAttribute("masterMind",masterMind);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
     
      HttpSession session = request.getSession();
      String button = request.getParameter("button");

      if (button.equals("newgame"))
      {
          masterMind = new MasterMind();
          session.setAttribute("masterMind",masterMind);
          request.setAttribute("CODESIZE", masterMind.CODESIZE);

          request.getRequestDispatcher("/index.jsp").forward(request, response);
      }
      else
      {
          if (session.getAttribute("masterMind") != null)
          {
              masterMind = (MasterMind)session.getAttribute("masterMind");
              request.setAttribute("CODESIZE", masterMind.CODESIZE);
              playMasterMind(request,response);
          }
          else
          {
              masterMind = new MasterMind();
              request.setAttribute("CODESIZE", masterMind.CODESIZE);
              playMasterMind(request,response);
          }

          if (masterMind.lives<=0 || masterMind.correct){ masterMind = new MasterMind(); }
      }


   }
}
