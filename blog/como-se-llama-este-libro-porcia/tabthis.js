function tabThis(elem,names){
    const childs = elem.childNodes;
    console.log(childs);
    let c = 0;

    const createDiv = function(clazz){
        const ret = document.createElement("div");
        ret.classList.add(clazz);
        return ret;
    };


    const tabs = [];
    childs.forEach( c => c.nodeType == 1 ? tabs.push(c) : undefined );
    const buttons = new Array(childs.length);

    const tabButtonsBar = createDiv("tab-buttons-bar");
    elem.append(tabButtonsBar);

    const tabContents = createDiv("tab-contents");
    elem.append(tabContents);

    const tabButtonListener = function(button,tab){
        return function(){
            console.log(button);
            tabs.forEach( t => t.classList.remove("tab-page-visible"));
            buttons.forEach( b => b.classList.remove("tab-button-selected"));

            tab.classList.add("tab-page-visible");
            button.classList.add("tab-button-selected");
        };
    };

   
    tabs.forEach( function(tab){
        const name = names[c];
        console.log( tab + " -- " + name );
        tab.classList.add("tab-page");
        tabContents.append(tab);

        const button = createDiv("tab-button");
        button.innerHTML = name;
        tabButtonsBar.append(button);
        button.onclick = tabButtonListener(button,tab);
        buttons[c] = button;

        
        c += 1;
    });


    buttons[0].onclick();

    elem.classList.add("tab-container");
    
}

function tabElements(elementName){
    const elements = document.getElementsByTagName(elementName);
    for( let i = 0 ; i < elements.length ; i++ ){
        const e = elements[i];
        tabThis(e,["Enunciado","Implementación"]);
    }
}
