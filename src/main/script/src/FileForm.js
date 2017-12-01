import React, {Component} from 'react';
import FlatButton from 'material-ui/FlatButton';
import TextField from 'material-ui/TextField';

const styles = {
uploadButton: {
verticalAlign: 'middle',
right: 5,
},
uploadInput: {
cursor: 'pointer',
position: 'absolute',
top: '50%',
bottom: 0,
right: 0,
left: '50%',
width: '100%',
height: '100%',
margin: 'auto',
opacity: 0,
},
};


class FileForm extends Component {
constructor(props) {
super(props);
this.state = {
	propertyFileName: '',
	scriptFile: '', 
	dbMacro: '',
};
this.handleScriptFile = this.handleScriptFile.bind(this);
this.handlePropertyFile = this.handlePropertyFile.bind(this);
this.handleDbPathChange = this.handleDbPathChange.bind(this);
this.handleScriptPathChange = this.handleScriptPathChange.bind(this);
this.handleDbMacroChange = this.handleDbMacroChange.bind(this);
this.handleSubmit = this.handleSubmit.bind(this);
this.handleReset = this.handleReset.bind(this);
}

handleDbPathChange(event) {
  event.preventDefault();
  this.setState({propertyFileName: event.target.value});
}

handleScriptPathChange(event) {
	event.preventDefault();
	this.setState({scriptFile: event.target.value});
}

handleDbMacroChange(event) {
	event.preventDefault();
	this.setState({dbMacro: event.target.value});
}

handlePropertyFile(event) {
  event.preventDefault();
  let propertyFileName = event.target.files[0].name;
  this.setState({propertyFileName: propertyFileName});
}

handleScriptFile(event) {
  event.preventDefault();
  let scriptFile = event.target.files[0];
  this.setState({scriptFile: scriptFile});
}


handleSubmit(event) {	
console.log("Event logging..", event);
console.log("Value: ", this.state.propertyFileName);
//TO DO - Perform flyway migration

event.preventDefault();
}

handleReset(event) {
event.preventDefault();
this.setState({propertyFileName: '', scriptFile: '', dbMacro: ''});
}

render() {
return (
	<div>
		<form action='.' encType='multipart/form-data' onSubmit={this.handleSubmit}>
		<div id="fileUpload">
		<FlatButton
		label="Choose a File"
		labelPosition="before"
		style={styles.uploadButton}
		containerElement="label">
		<input type="file" style={styles.uploadInput} 
		onChange={this.handlePropertyFile.bind(this)} />
		</FlatButton>
		<TextField
		floatingLabelText="Path to db info."
		value={this.state.propertyFileName}
		onChange={this.handleDbPathChange.bind(this)}
		style={{width: 325}}
		/><br />
		<FlatButton
		label="Choose a File"
		labelPosition="before"
		style={styles.uploadButton}
		containerElement="label">
		<input type="file" style={styles.uploadInput} onChange={this.handleScriptFile.bind(this)} />
		</FlatButton>
		<TextField
		floatingLabelText="Path to flyway scripts."
		value={this.state.scriptFile}
		onChange={this.handleScriptPathChange.bind(this)}
		style={{width: 325}}
		/><br />
		</div>
		<div id="dbMacroField">
		<TextField
		floatingLabelText="Database macro"
		value={this.state.dbMacro}
		onChange={this.handleDbMacroChange.bind(this)}
		/><br />
		</div>
		<div id="submitButton">
			<FlatButton href="#" onClick={this.handleSubmit} label="Submit" backgroundColor="orange"/>
		</div>
		&nbsp;&nbsp;
		<div id="resetButton">
			<FlatButton href="#" onClick={this.handleReset.bind(this)} label="Reset" />
		</div>
		</form>
  </div>
);
}
}

export default FileForm;