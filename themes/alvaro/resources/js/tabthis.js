function tabThisCSSLink(){
    const link = document.createElement("link");
    link.href = "/tabthis.css";
    link.type = "text/css";
    link.rel = "stylesheet";
    document.getElementsByTagName("head")[0].appendChild(link);
}

function tabThisCSSElement(){
    const style = document.createElement("style");

    style.innerHTML = `
.tab-container{
    display: block;
}

.tab-contents{
    background-color: #f0f0f0;
    border-top: none;
    border-bottom: 1px black solid;
    border-left: 1px black solid;
    border-right: 1px black solid;
    display: block;

    margin-top: 0.0em;
    padding-top: 0.1em;

    z-index: 5;
}

.tab-page{
    display: none;
}

.tab-page-visible{
    display: block;
}

.tab-buttons-bar{
    display : block;
    padding-bottom: 1px;
    border-bottom: 1px black solid;
    line-height: normal; 
}

.tab-button{
    background-color: #b0b0b0;
    display: inline;

    border-bottom: 1px black solid;
    border-left: 1px black solid;
    border-right: 1px black solid;
    border-top: 1px black solid;

    border-top-left-radius: 3px;
    border-top-right-radius: 3px;

    padding: 0.3em;

    margin-right : 0.1em;

    padding-bottom: 1.5px;
}

.tab-button-selected{
    background-color: #f0f0f0;
    border-bottom: 1px #f0f0f0 solid;
    z-index: 10;
}`;

    document.getElementsByTagName("body")[0].appendChild(style);
}

function tabThis(elem,names){
    log( "tabThis --> ");
    const childs = elem.childNodes;
    log( " " + childs);
    let c = 0;

    const createDiv = function(clazz){
        log( "creo div:" + clazz );
        const ret = document.createElement("div");
        log( "div creada:" + ret );
        ret.classList.add(clazz);
        log( "div con class puesta:" + ret.classList );
        return ret;
    };


    const tabs = [];
    childs.forEach( c => c.nodeType == 1 ? tabs.push(c) : undefined );
    log( "  tabs:" + childs );
    const buttons = new Array(childs.length);
    log( "  buttons vacío:" + buttons );

    const tabButtonsBar = createDiv("tab-buttons-bar");
    log( "  tabButtonsBar:" + tabButtonsBar );
    elem.appendChild(tabButtonsBar);
    log( "  tabButtonsBar añadido");

    const tabContents = createDiv("tab-contents");
    log( "  tabContents:" + tabContents );
    elem.appendChild(tabContents);
    log( "  tabContents añadido");

    const tabButtonListener = function(button,tab){
        return function(){
            console.log(button);
            tabs.forEach( t => t.classList.remove("tab-page-visible"));
            buttons.forEach( b => b.classList.remove("tab-button-selected"));

            tab.classList.add("tab-page-visible");
            button.classList.add("tab-button-selected");
        };
    };

    log( "  creo tab");
    tabs.forEach( function(tab){
        const name = names[c];
        log( tab + " -- " + name );
        tab.classList.add("tab-page");
        tabContents.appendChild(tab);

        const button = createDiv("tab-button");
        button.innerHTML = name;
        tabButtonsBar.appendChild(button);
        button.onclick = tabButtonListener(button,tab);
        buttons[c] = button;

        
        c += 1;
    });


    buttons[0].onclick();

    elem.classList.add("tab-container");
    
}

function tabElements(elementName,tabNames){
    const elements = document.getElementsByTagName(elementName);
    for( let i = 0 ; i < elements.length ; i++ ){
        const e = elements[i];
        log( elementName + " " + e );
        tabThis(e,tabNames);
    }
}

function log(s){
    //document.write("<p>" + s );
}
