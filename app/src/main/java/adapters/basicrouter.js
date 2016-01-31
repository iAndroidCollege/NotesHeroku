var http = require('http');
var url = require('url');

var routs = {
	'GET':{
		'/': (req, res)=>{
			res.writeHead(200, {'Content-Type':'text/html'});
			res.end('<h1>Hello, Router</h1>');
		},

		'/about': (req, res)=>{
			res.writeHead(200, {'Content-Type':'text/html'});
			res.end('<h1>About Page</h1>');
		},

		'/api/getinfo': (req, res)=>{
			res.writeHead(200, {'Content-Type':'application/json'});
			res.end(JSON.stringify(req.queryParams));
		}
	},
	'POST':{

	},
	'NA':(req, res)=>{
			res.writeHead(404, {'Content-Type':'text/html'});
			res.end('<h1>Content Not Found - 404</h1>');
	}
}



function router(req, res){
	//true stands for jsonObject
	var baseUri = url.parse(req.url, true);
	var resolvedRoute = routs[req.method];
	var route = resolvedRoute[baseUri.pathname];

	if (route != undefined) {
		req.queryParams = baseUri.query;
		route(req, res);
	}
	else{
		routs['NA'](req, res);
	}
}

http.createServer(router).listen(3000);
console.log('Server Running On Port 3000');