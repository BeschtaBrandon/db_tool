import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import logo from './images/tr.PNG';
import './App.css';
import './css/styles.css';
import FileForm from './FileForm'

class App extends Component {
	
	  constructor(props) {
    super(props);
    this.state = {
      file: '',
    };
	  }

  render() {
    return (
	
	<MuiThemeProvider>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Provide the following:<br/>Property file, sql script, and a database macro</h1>
        </header>
			<FileForm/>
		<footer>
			<p>&copy; 2017 Thomson Reuters.</p>
		</footer>
      </div>
	  </MuiThemeProvider>
    );
  }
}

export default App;
