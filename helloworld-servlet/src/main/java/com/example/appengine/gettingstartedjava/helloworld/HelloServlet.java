/**
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.example.appengine.gettingstartedjava.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "helloworld", value = "/webhook")
public class HelloServlet extends HttpServlet {

	private static String VERIFY_TOKEN = "thou_shall_pass";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (new String(req.getParameter("hub.mode")).equals("subscribe")
				&& new String(req.getParameter("hub.verify_token")).equals(VERIFY_TOKEN)) {
			PrintWriter out = resp.getWriter();
			out.println(new String(req.getParameter("hub.challenge")));
		} else {
			System.out.println("unexpected !!!!!!");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	}
}
