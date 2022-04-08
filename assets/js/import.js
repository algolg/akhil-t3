function importNav() {
  navParent = document.getElementById("navParent");
  nav = document.createElement("div");
  nav.innerHTML = `
<link rel="stylesheet" href="../../fragments/main.css">
<div id="top" class="rounded-corners box bar">
    <div class="bar-title centered-svg-container">
        <h1 class="centered-svg" style="margin-left:10px;">Welcome to Akhil</h1>
    </div>
    <div class="bar-links">
        <a class="link top-link main-link" href="index">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <abbr title="Home Page">
                        <h5>Home Page</h5>
                    </abbr>
                </div>
            </div>
        </a>
        <a class="link top-link main-link" href="techtalks">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <abbr title="Tech Talks">
                        <h5>Tech Talks</h5>
                    </abbr>
                </div>
            </div>
        </a>
        <a class="link bottom-link main-link" href="testplans">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <abbr title="Test Prep">
                        <h5>Test Prep</h5>
                    </abbr>
                </div>
            </div>
        </a>
        <a class="link bottom-link main-link" href="sorts">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <abbr title="Sorts">
                        <h5>Sorts</h5>
                    </abbr> 
                </div>
            </div>
        </a>
        <a id="last-link" class="link bottom-link main-link" href="https://github.com/algolg" alt="GitHub Profile" target="_blank" rel="noopener noreferrer">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <abbr title="GitHub Profile">
                        <h5>GitHub Profile</h5>
                    </abbr> 
                </div>
            </div>
        </a>
        <a id="dropdown-link" class="link bottom-link" onclick="toggleResponsive()">
            <div class="centered-svg-container">
                <div class="centered-svg">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                    </svg>
                </div>
            </div>
        </a>
    </div>
</div>
  `
  navParent.appendChild(nav);
}