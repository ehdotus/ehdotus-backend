function Ehdotin() {
    // tällä voisi olla jotain dataa, vaikkapa vaikeuksista
}

// lähes suora copy-paste three.js -dokumentaatiosta
function EhdotinGfx() {
    this.scene = null;
    this.camera = null;
    this.cube = null;
    this.renderer = null;
}

EhdotinGfx.prototype.init = function () {
    this.scene = new THREE.Scene();
    this.camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    this.renderer = new THREE.WebGLRenderer();

    this.renderer.setSize(window.innerWidth, window.innerHeight);

    document.getElementById("visu").appendChild(this.renderer.domElement);

    var geometry = new THREE.BoxGeometry(1, 1, 1);
    var material = new THREE.MeshBasicMaterial({color: 0x00ff00});

    this.cube = new THREE.Mesh(geometry, material);
    this.scene.add(this.cube);
    this.camera.position.z = 5;
};
